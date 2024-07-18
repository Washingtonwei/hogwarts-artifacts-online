package edu.tcu.cs.hogwartsartifactsonline.client.imagestorage;

import java.io.IOException;
import java.io.InputStream;

public interface ImageStorageClient {

    String uploadImage(String containerName, String originalImageName, InputStream data, long length) throws IOException;

}
