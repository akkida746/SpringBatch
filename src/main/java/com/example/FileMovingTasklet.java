package com.example;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.*;

/**
 * @author Akash Deep
 * @date 11/10/2019
 **/

@Component
public class FileMovingTasklet implements Tasklet {

    @Value("${new.files.source}")
    private FileSystemResource sourceDirectory;

    @Value("${old.files.source}")
    private FileSystemResource targetDirectory;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        InputStream inStream = null;
        OutputStream outStream = null;
        File[] files;
        File dir = sourceDirectory.getFile();
        Assert.state(dir.isDirectory());
        files = dir.listFiles();
        File bfile = null;
        for (int i = 0; i < files.length; i++) {


            bfile = new File(targetDirectory.getURL().getPath() + File.separator + files[i].getName());

            inStream = new FileInputStream(files[i]);
            outStream = new FileOutputStream(bfile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
            inStream.close();
            outStream.close();
        }
        return RepeatStatus.FINISHED;
    }
}
