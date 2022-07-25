/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanchay.server.dto.model.files;

import com.jcraft.jsch.ChannelSftp.LsEntry;

/**
 *
 * @author User
 */
public class RemoteSftpFile {
    
    protected LsEntry lsEntry;
    
    protected RemoteSftpFile parent;
    
    protected String path = ".";
    
    public RemoteSftpFile(LsEntry entry, RemoteSftpFile p, String pth)
    {
        lsEntry = entry;
        parent = p;
        path = pth;
    }
    
    public LsEntry getLsEntry()
    {
        return lsEntry;
    }
    
    public String getPath()
    {
        return path;
    }
    
    public RemoteSftpFile getParent()
    {
        return parent;
    }
    
    public String toString()
    {
        return path;
    }
}
