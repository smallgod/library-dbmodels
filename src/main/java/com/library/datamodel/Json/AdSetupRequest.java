package com.library.datamodel.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;
import java.util.List;

public class AdSetupRequest implements JsonDataModel {

    /*
    
    {
   "method":"DAILY_SETUP_STEP2",
   "terminal_detail":[
      {
         "display_date":"2017-01-27",
         "terminals":[
            {
               "task_id":3480434,
               "task_name":3480434,
               "terminal_id":230901364454349,
               "terminal_width":1080,
               "terminal_height":720,
               "program_ids":[
                  1485513768,
                  1485513769
               ]
            },
            {
               "task_id":1480434,
               "task_name":3480434,
               "terminal_id":230901364454350,
               "terminal_width":1080,
               "terminal_height":720,
               "program_ids":[
                  1485513769,
                  1485513768
               ]
            }
         ]
      }
   ],
   "program_detail":[
      {
         "display_date":"2017-01-27",
         "program_ids":[
            {
               "program_id":1485513769,
               "status":"UPDATED",
               "display_layout":"3SPLIT",
               "display_times":[
                  {
                     "starttime":"14:36:49",
                     "stoptime":"14:39:49"
                  },
                  {
                     "starttime":"14:46:49",
                     "stoptime":"14:49:49"
                  }
               ],
               "resources":[
                  {
                     "resource_id":97354630322880,
                     "resource_detail":"30Movies_2017.mp4",
                     "resource_type":"VIDEO",
                     "status":"OLD",
                     "sequence":1
                  },
                  {
                     "resource_id":97354630323904,
                     "resource_detail":"breadV.jpg",
                     "resource_type":"IMAGE",
                     "status":"NEW",
                     "sequence":2
                  },
                  {
                     "resource_id":97230072297028,
                     "resource_detail":"Fist Header text",
                     "resource_type":"HEADER_TEXT",
                     "status":"NEW"
                  },
                  {
                     "resource_id":97230473397020,
                     "resource_detail":"This is my first scrolling text here..",
                     "resource_type":"SCROLL_TEXT",
                     "status":"NEW"
                  }
               ],
                "text": [
                    {
                        "text": "This is scrolling text here..",
                        "type": "SCROLL_TEXT"
                    },
                    {
                        "text": "This is Header text",
                        "type": "HEADER_TEXT"
                    }
                ]
    
    
    
    
            },
            {
               "program_id":1485513768,
               "status":"NEW",
               "display_layout":"TEXT",
               "display_times":[
                  {
                     "starttime":"14:50:49",
                     "stoptime":"14:59:49"
                  }
               ],
               "resources":[
                  {
                     "resource_id":97354630325888,
                     "resource_detail":"chimei-lcd2.vob",
                     "resource_type":"VIDEO",
                     "status":"OLD",
                     "sequence":1
                  },
                  {
                     "resource_id":97354630323904,
                     "resource_detail":"breadV.jpg",
                     "resource_type":"IMAGE",
                     "status":"NEW",
                     "sequence":2
                  },
                  {
                     "resource_id":97230472297021,
                     "resource_detail":"2nd Header Text",
                     "resource_type":"HEADER_TEXT",
                     "status":"NEW"
                  },
                  {
                     "resource_id":97230472297020,
                     "resource_detail":"My next scrolling next, part 2...",
                     "resource_type":"SCROLL_TEXT",
                     "status":"NEW"
                  }
               ],
                "text": [
                    {
                        "text": "This is scrolling text here..",
                        "type": "SCROLL_TEXT"
                    },
                    {
                        "text": "This is Header text",
                        "type": "HEADER_TEXT"
                    }
                ]
    
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

            @SerializedName(value = "task_id")
            private int taskId;

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

            public int getTaskId() {
                return taskId;
            }

            public void setTaskId(int taskId) {
                this.taskId = taskId;
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

            @SerializedName(value = "program_id")
            private int programId;

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

                @SerializedName(value = "resource_id")
                private long resourceId;

                @SerializedName(value = "resource_detail")
                private String resourceDetail;

                @SerializedName(value = "resource_type")
                private String resourceType;

                @SerializedName(value = "status")
                private String status;

                @SerializedName(value = "sequence")
                private int sequence;

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

                public String getResourceType() {
                    return resourceType;
                }

                public void setResourceType(String resourceType) {
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

            }

        }

        public class Text {

            @SerializedName("text")
            @Expose
            private String text;
            @SerializedName("type")
            @Expose
            private String type;

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
