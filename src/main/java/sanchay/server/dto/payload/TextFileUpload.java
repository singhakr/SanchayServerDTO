/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanchay.server.dto.payload;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import sanchay.server.dto.model.files.RemoteFile;

/**
 *
 * @author User
 */
@Component
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TextFileUpload implements Serializable {
    private RemoteFile remoteFile;

    // Base64 encoded
    private String textFileContents;
}
