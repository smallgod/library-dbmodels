package com.library.datamodel.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;
import java.util.List;

public class AdSetupRequest implements JsonDataModel {

    /*

        {
          "method": "UPLOAD_SCHEDULE_TO_DSM",
          "terminal_detail": [
            {
              "display_date": "2017-05-02",
              "terminals": [
                {
                  "terminal_id": "233097221599994",
                  "terminal_width": 1920,
                  "terminal_height": 1080,
                  "task_idx": 1493101974,
                  "task_idy": 1493101989,
                  "task_idz": 1493101993,
                  "task_name": "First Terminal",
                  "program_ids": [
                    1493741055
                  ]
                }
              ]
            }
          ],
          "program_detail": [
            {
              "display_date": "2017-05-02",
              "program_ids": [
                {
                  "entityId": 230,
                  "program_id": 1493741055,
                  "campaign_id":848483993,
                  "status": "NEW",
                  "display_layout": "FULLSCREEN",
                  "display_times": [
                    {
                      "starttime": "19:05:00",
                      "stoptime": "19:06:00"
                    }
                  ],
                  "resources": [
                    {
                      "entityId": 232,
                      "resource_id": 97893813781568,
                      "resource_detail": "resname_1493741024751.PNG",
                      "resource_type": 0,
                      "status": "OLD",
                      "sequence": 1
                    }
                  ],
                  "text": []
                }
              ]
            }
          ]
        }

     */
    @SerializedName(value = "method")
    private String methodName;

    @SerializedName(value = "terminal_detail")
    private List<TerminalDetail> terminalDetail;

    @SerializedName(value = "program_detail")
    private List<ProgramDetail> programDetail;

    public class TerminalDetail {

        @SerializedName(value = "display_date")
        private String displayDate;

        @SerializedName(value = "terminals")
        private List<Terminal> terminals;

        public String getDisplayDate() {
            return displayDate;
        }

        public void setDisplayDate(String displayDate) {
            this.displayDate = displayDate;
        }

        public List<Terminal> getTerminals() {
            return terminals;
        }

        public void setTerminals(List<Terminal> terminals) {
            this.terminals = terminals;
        }

        public class Terminal {

            @SerializedName(value = "terminal_id")
            private String terminalId;

            @SerializedName(value = "terminal_width")
            private int terminalWidth;

            @SerializedName(value = "terminal_height")
            private int terminalHeight;

            @SerializedName(value = "task_idx")
            private int taskIdX;

            @SerializedName(value = "task_idy")
            private int taskIdY;
            
            @SerializedName(value = "task_idz")
            private int taskIdZ;

            @SerializedName(value = "task_name")
            private String taskName;

            @SerializedName(value = "program_ids")
            private List<Integer> programIdList;

            public String getTerminalId() {
                return terminalId;
            }

            public void setTerminalId(String terminalId) {
                this.terminalId = terminalId;
            }

            public String getTaskName() {
                return taskName;
            }

            public void setTaskName(String taskName) {
                this.taskName = taskName;
            }

            public List<Integer> getProgramIdList() {
                return programIdList;
            }

            public void setProgramIdList(List<Integer> programIdList) {
                this.programIdList = programIdList;
            }

            public int getTerminalWidth() {
                return terminalWidth;
            }

            public void setTerminalWidth(int terminalWidth) {
                this.terminalWidth = terminalWidth;
            }

            public int getTerminalHeight() {
                return terminalHeight;
            }

            public void setTerminalHeight(int terminalHeight) {
                this.terminalHeight = terminalHeight;
            }

            public int getTaskIdX() {
                return taskIdX;
            }

            public void setTaskIdX(int taskIdX) {
                this.taskIdX = taskIdX;
            }

            public int getTaskIdY() {
                return taskIdY;
            }

            public void setTaskIdY(int taskIdY) {
                this.taskIdY = taskIdY;
            }

            public int getTaskIdZ() {
                return taskIdZ;
            }

            public void setTaskIdZ(int taskIdZ) {
                this.taskIdZ = taskIdZ;
            }

        }
    }

    public class ProgramDetail {

        @SerializedName(value = "display_date")
        private String displayDate;

        @SerializedName(value = "program_ids")
        private List<Program> programIds;

        public String getDisplayDate() {
            return displayDate;
        }

        public void setDisplayDate(String displayDate) {
            this.displayDate = displayDate;
        }

        public List<Program> getProgramIds() {
            return programIds;
        }

        public void setProgramIds(List<Program> programIds) {
            this.programIds = programIds;
        }

        public class Program {

            @Expose(deserialize = false, serialize = false)
            private long entityId;

            //private transient long entityId;
            @SerializedName(value = "program_id")
            private int programId;

            @SerializedName(value = "campaign_id")
            private int campaignId;

            @SerializedName(value = "status")
            private String status;

            @SerializedName(value = "display_layout")
            private String displayLayout;

            @SerializedName(value = "display_times")
            private List<DisplayTime> displayTimesList;

            @SerializedName(value = "resources")
            private List<Resources> resources;

            @SerializedName("text")
            @Expose
            private List<Text> text = null;

            public List<Text> getText() {
                return text;
            }

            public void setText(List<Text> text) {
                this.text = text;
            }

            public List<Resources> getResources() {
                return resources;
            }

            public void setResources(List<Resources> resources) {
                this.resources = resources;
            }

            public int getProgramId() {
                return programId;
            }

            public void setProgramId(int programId) {
                this.programId = programId;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDisplayLayout() {
                return displayLayout;
            }

            public void setDisplayLayout(String displayLayout) {
                this.displayLayout = displayLayout;
            }

            public List<DisplayTime> getDisplayTimesList() {
                return displayTimesList;
            }

            public void setDisplayTimesList(List<DisplayTime> displayTimesList) {
                this.displayTimesList = displayTimesList;
            }

            public long getEntityId() {
                return entityId;
            }

            public void setEntityId(long entityId) {
                this.entityId = entityId;
            }

            public int getCampaignId() {
                return campaignId;
            }

            public void setCampaignId(int campaignId) {
                this.campaignId = campaignId;
            }

            public class DisplayTime {

                @SerializedName(value = "starttime")
                private String starttime;

                @SerializedName(value = "stoptime")
                private String stoptime;

                public String getStarttime() {
                    return starttime;
                }

                public void setStarttime(String starttime) {
                    this.starttime = starttime;
                }

                public String getStoptime() {
                    return stoptime;
                }

                public void setStoptime(String stoptime) {
                    this.stoptime = stoptime;
                }
            }

            public class Resources {

                @Expose(serialize = false, deserialize = false)
                private long entityId;

                //private transient long entityId;// will not be serialized or deserialized
                @SerializedName(value = "resource_id")
                private long resourceId;

                @SerializedName(value = "upload_id")
                private String uploadId;//the Id we generated from millis of time now when we were uploading the image resource

                @SerializedName(value = "resource_detail")
                private String resourceDetail;

                @SerializedName(value = "resource_type")
                private int resourceType;

                @SerializedName(value = "status")
                private String status;

                @SerializedName(value = "sequence")
                private int sequence;

                @SerializedName(value = "uploaded_to_dsm")
                private boolean isUploadedToDSM;

                public long getEntityId() {
                    return entityId;
                }

                public void setEntityId(long entityId) {
                    this.entityId = entityId;
                }

                public long getResourceId() {
                    return resourceId;
                }

                public void setResourceId(long resourceId) {
                    this.resourceId = resourceId;
                }

                public String getResourceDetail() {
                    return resourceDetail;
                }

                public void setResourceDetail(String resourceDetail) {
                    this.resourceDetail = resourceDetail;
                }

                public int getResourceType() {
                    return resourceType;
                }

                public void setResourceType(int resourceType) {
                    this.resourceType = resourceType;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public int getSequence() {
                    return sequence;
                }

                public void setSequence(int sequence) {
                    this.sequence = sequence;
                }

                public String getUploadId() {
                    return uploadId;
                }

                public void setUploadId(String uploadId) {
                    this.uploadId = uploadId;
                }

                public boolean isIsUploadedToDSM() {
                    return isUploadedToDSM;
                }

                public void setIsUploadedToDSM(boolean isUploadedToDSM) {
                    this.isUploadedToDSM = isUploadedToDSM;
                }

            }

            public class Text {

                @SerializedName("text")
                @Expose
                private String text;

                @SerializedName("type")
                @Expose
                private String type;

                @SerializedName("text_id")
                @Expose
                private long textId;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public long getTextId() {
                    return textId;
                }

                public void setTextId(long textId) {
                    this.textId = textId;
                }

            }

        }

    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<TerminalDetail> getTerminalDetail() {
        return terminalDetail;
    }

    public void setTerminalDetail(List<TerminalDetail> terminalDetail) {
        this.terminalDetail = terminalDetail;
    }

    public List<ProgramDetail> getProgramDetail() {
        return programDetail;
    }

    public void setProgramDetail(List<ProgramDetail> programDetail) {
        this.programDetail = programDetail;
    }

}
