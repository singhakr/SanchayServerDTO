/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.co.sanchay.server.dto.tree.impl;

import com.jcraft.jsch.ChannelSftp.LsEntry;
import java.io.File;
import java.io.Serializable;
import javax.swing.tree.DefaultMutableTreeNode;

import in.co.sanchay.server.dto.tree.ExplorableTreeNode;
import org.springframework.stereotype.Component;
import in.co.sanchay.server.dto.model.files.RemoteFile;
import in.co.sanchay.server.dto.model.files.RemoteSftpFile;

/**
 *
 * @author User
 */
@Component
public class RemoteFileNode extends DefaultMutableTreeNode implements ExplorableTreeNode, Serializable {

    protected boolean explored = false;
    
    public static int SPRING_MODE = 0;
    public static int RMI_MODE = 1;
    public static int SFTP_MODE = 2;
    
    protected int mode = SPRING_MODE;
    
    public RemoteFileNode()
    {
        
    }
    
//    protected RMIFileSystemRI rmiFileSytem;
    
//    protected RemoteFileNode(File file, RemoteSftpFile remoteFile, RemoteFile rfile, RMIFileSystemRI rmiFS, int mode) {
    protected RemoteFileNode(File file, RemoteSftpFile remoteFile, RemoteFile rfile, int mode) {
        
        this.mode = mode;

        if(mode == RMI_MODE || mode == SPRING_MODE)
        {
//            setUserObject(file);
            setUserObject(rfile);
//            rmiFileSytem = rmiFS;
            
        }
        else if(mode == SFTP_MODE)
            setUserObject(remoteFile);
        
    }
    
//    public static RemoteFileNode getRemoteFileNodeInstance(RemoteSftpFile sftpfile, File file, RemoteFile rfile, RMIFileSystemRI rmiFS, int mode)
    public static RemoteFileNode getRemoteFileNodeInstance(RemoteSftpFile sftpfile, File file, RemoteFile rfile, int mode)
    {
        RemoteFileNode fn = null;
        
        if(mode == SFTP_MODE)
//            fn = new RemoteFileNode(null, sftpfile, null, null, SFTP_MODE);
            fn = new RemoteFileNode(null, sftpfile, null, SFTP_MODE);
        else if(mode == RMI_MODE)
//            fn = new RemoteFileNode(file, null, rfile, rmiFS, RMI_MODE);
            fn = new RemoteFileNode(file, null, rfile, RMI_MODE);
        else if(mode == SPRING_MODE)
//            fn = new RemoteFileNode(file, null, rfile, rmiFS, RMI_MODE);
            fn = new RemoteFileNode(file, null, rfile, SPRING_MODE);

        return fn;
    }

    public boolean getAllowsChildren() { return isDirectory(); }
    public boolean isLeaf() 	 { return !isDirectory(); }
    
    private RemoteSftpFile getSFTPFile()
    {
        if(mode == SFTP_MODE)
            return (RemoteSftpFile)getUserObject();
        
        return null;
    }
    
    private RemoteFile getRemoteFile()
    {
        if(mode == RMI_MODE || mode == SPRING_MODE)
            return (RemoteFile) getUserObject();
        
        return null;
    }
    
    public boolean isExplored() { return explored; }
    
    public boolean isDirectory() {
        if(mode == SFTP_MODE)
        {
            RemoteSftpFile file = getSFTPFile();

            if(file != null)
            {
                LsEntry entry = file.getLsEntry();
                if(entry != null)
                {
                    return entry.getAttrs().isDir();
                }
                else
                    return true;
            }
        }
        else
        {
            RemoteFile file = getRemoteFile();

            if(file != null)
            {
                return file.isDirectory();
            }            
            else
                return true;
        }
        
        return false;
    }
    
    public RemoteSftpFile getRemoteSftpFile()
    {
        return (RemoteSftpFile) getUserObject();
    }
    
    public RemoteFile getRemoteRMIFile()
    {
        return (RemoteFile) getUserObject();
    }
    
    public String toString() {
        if(mode == SFTP_MODE)
        {
            RemoteSftpFile file = getSFTPFile();

            if(file != null)
            {
                LsEntry entry = file.getLsEntry();
                String filename = entry.getFilename();
                int index = filename.lastIndexOf(File.separator);

                return (index != -1 && index != filename.length()-1) ?
                    filename.substring(index+1) :
                    filename;
            }
            else
                return "Home";
        }
        else{
            RemoteFile file = getRemoteFile();

            if(file != null)
            {
                return file.getFileName();
            }
            else
                return "Home";            
        }
    }
    
//    public RMIFileSystemRI getRMIFileSystem()
//    {
//        return rmiFileSytem;
//    }

    public void explore() {
	if(!isDirectory())
	    return;
	
	if(!isExplored()) {
            
            int ccount = getChildCount();
	    
	    if(ccount == 0)
		return;
	    
//	    for(int i=0; i < ccount; ++i)
//            {
//                RemoteFileNode cnode = (RemoteFileNode) getChildAt(i);
//
//                if(mode == RMI_MODE)
////                    add(getRemoteFileNodeInstance(null, null, (RemoteFile) cnode.getUserObject(), rmiFileSytem, RMI_MODE));
//                    add(getRemoteFileNodeInstance(null, null, (RemoteFile) cnode.getUserObject(), RMI_MODE));
//                else if(mode == SFTP_MODE)                    
////                    add(getRemoteFileNodeInstance((RemoteSftpFile) cnode.getUserObject(), null, null, null, SFTP_MODE));
//                    add(getRemoteFileNodeInstance((RemoteSftpFile) cnode.getUserObject(), null, null, SFTP_MODE));
//            }
	    
	    explored = true;
	}        
    }    
}
