/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanchay.server.dto.model.files;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class RemoteFile implements Serializable {
    
    protected String fileName;
    protected String relativePath;
    protected String absolutePathOnServer;
    protected String absolutePathOnClient;
    protected boolean directory;
    
    public RemoteFile()
    {
        
    }
    
    public RemoteFile(String name, String relPath, String absPathServer, String absPathClient, boolean isDir)
    {
        fileName = name;
        relativePath = relPath;
        absolutePathOnServer = absPathServer;
        absolutePathOnClient = absPathClient;
        directory = isDir;
    }
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getAbsolutePathOnServer() {
        return absolutePathOnServer;
    }

    public void setAbsolutePathOnServer(String absolutePath) {
        this.absolutePathOnServer = absolutePath;
    }

    public String getAbsolutePathOnClient() {
        return absolutePathOnClient;
    }

    public void setAbsolutePathOnClient(String absolutePath) {
        this.absolutePathOnClient = absolutePath;
    }

    public boolean isDirectory() {
        return directory;
    }

    public void setDirectory(boolean isDirectory) {
        this.directory = isDirectory;
    }
    
    public String toString()
    {
        return absolutePathOnServer;
    }
}

