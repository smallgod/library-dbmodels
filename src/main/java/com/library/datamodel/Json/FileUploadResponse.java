package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

public class FileUploadResponse {

    /*
    
        {
            "success": true,
            "data": [
              {
                "file_id": 6447483894, 
                "is_uploaded": true,
                "description": "successfuly uploaded"
              },
              {
                "file_id": 992284994, 
                "is_uploaded": false,
                "description": "file too large"
              }
            ]
        }
    
     */
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private Set<Data> data = new HashSet<>();

    private FileUploadResponse(boolean success) {
        this.success = success;
    }

    public FileUploadResponse() {
        this(Boolean.TRUE);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Set<Data> getData() {
        return data;
    }

    public void setData(Set<Data> data) {
        this.data = data;

    }

    public class Data {

        @SerializedName("file_id")
        @Expose
        private long fileId;

        @SerializedName("is_uploaded")
        @Expose
        private boolean isUploaded;

        @SerializedName("description")
        @Expose
        private String description;

        public long getFileId() {
            return fileId;
        }

        public void setFileId(long fileId) {
            this.fileId = fileId;
        }

        public boolean getIsUploaded() {
            return isUploaded;
        }

        public void setIsUploaded(boolean isUploaded) {
            this.isUploaded = isUploaded;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }

}
