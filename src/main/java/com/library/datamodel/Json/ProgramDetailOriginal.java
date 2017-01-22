package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;
import java.util.List;

public class ProgramDetailOriginal implements JsonDataModel {

    /*
    
    {
   "method":"PROGRAM_DETAIL",
   "data":[
      {
         "display_date":"2017-01-10",
         "program_ids":[
            {
               "program_id":19011480463480900778,
               "status":"UPDATED",
               "display_layout":"3SPLIT",
               "display_times":[
                  {
                     "starttime":"21:06:49",
                     "stoptime":"21:07:49"
                  },
                  {
                     "starttime":"22:06:49",
                     "stoptime":"22:07:49"
                  }
               ],
               "resources": [
                        {
                            "resource_id": 5480212808,
                            "resource_detail": "restaurant_front.mp4",
                            "resource_type": "VIDEO",
                            "status": "OLD", //NEW - UPDATED - OLD ----- resource is new, updated OR old
                        }
                    ]
            },
            {
               "program_id":97011480463480900778,
               "status":"NEW",
               "display_layout":"TEXT_ONLY",
               "display_times":[
                  {
                     "starttime":"21:06:49",
                     "stoptime":"21:07:49"
                  },
                  {
                     "starttime":"22:06:49",
                     "stoptime":"22:07:49"
                  }
               ],
               "resources": [
                        {
                            "resource_id": 5480212808,
                            "resource_detail": "restaurant_front.mp4",
                            "resource_type": "VIDEO",
                            "status": "OLD", //NEW - UPDATED - OLD ----- resource is new, updated OR old
                        },
                        {
                            "resource_id": 2481434800,
                            "resource_detail": "This is Header text",
                            "resource_type": "HEADER_TEXT",
                            "status": "NEW", //NEW - UPDATED - OLD ----- resource is new, updated OR old
                        },
                        {
                            "resource_id": 2481434801,
                            "resource_detail": "This is scrolling text here..",
                            "resource_type": "SCROLL_TEXT",
                            "status": "NEW", //NEW - UPDATED - OLD ----- resource is new, updated OR old
                        },
                        {
                            "resource_id": 2481434800,
                            "resource_detail": "swimming pool.jpg",
                            "resource_type": "IMAGE",
                            "status": "NEW", //NEW - UPDATED - OLD ----- resource is new, updated OR old
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

    @SerializedName(value = "data")
    private List<Data> data;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public class Data {

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
            private String programId;

            @SerializedName(value = "status")
            private String status;

            @SerializedName(value = "display_layout")
            private String displayLayout;

            @SerializedName(value = "display_times")
            private List<DisplayTime> displayTimesList;

            @SerializedName(value = "resources")
            private List<Resources> resources;

            public List<Resources> getResources() {
                return resources;
            }

            public void setResources(List<Resources> resources) {
                this.resources = resources;
            }

            public String getProgramId() {
                return programId;
            }

            public void setProgramId(String programId) {
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
                private String resourceId;

                @SerializedName(value = "resource_detail")
                private String resourceDetail;

                @SerializedName(value = "resource_type")
                private String resourceType;

                @SerializedName(value = "status")
                private String status;
                
                @SerializedName(value = "sequence")
                private int sequence;

                public String getResourceId() {
                    return resourceId;
                }

                public void setResourceId(String resourceId) {
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
    }

}
