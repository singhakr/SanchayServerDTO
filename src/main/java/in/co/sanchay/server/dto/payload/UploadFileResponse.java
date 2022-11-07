package in.co.sanchay.server.dto.payload;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UploadFileResponse {
    private String fileName;
    private String charset;

    public String getFileName() {
        return fileName;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    private String filePath;
    private String fileType;
    private long size;

    public UploadFileResponse(String fileName, String charset, String filePath, String fileType, long size) {
        this.fileName = fileName;
        this.charset = charset;
        this.filePath = filePath;
        this.fileType = fileType;
        this.size = size;
    }
}
