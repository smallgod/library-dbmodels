package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;
import java.util.List;

public class PlayerDetailOLD implements JsonDataModel {

    /*
    
    {
    "method": "PLAYER_DETAIL",
    "data": [
        {
            "display_date": "2017-01-10",
            "terminals": [
                {
                    "task_id": 3480434808,
                    "task_name": 3480434808,
                    "terminal_id": 49011480463480900778,
                    "program_ids": [
                        1480212808,
                        6280434808,
                        2481434808,
                        8783334808,
                        7480224808,
                        9080434808
                    ],
                },
                {
                    "task_id": 1480434808,
                    "task_name": 3480434808,
                    "terminal_id": 89011480463480900778,
                    "program_ids": [
                        1480212808,
                        6280434808,
                        2481434808,
                        8783334808,
                        7480224808,
                        9080434808
                    ],
                }
            ]
        },
        {
            "display_date": "2017-01-11",
            "terminals": [
                {
                    "task_id": 3480434808,
                    "task_name": 3480434808,
                    "terminal_id": 49011480463480900778,
                    "program_ids": [
                        1480212808,
                        6280434808,
                        2481434808,
                        8783334808,
                        7480224808,
                        9080434808
                    ],
                },
                {
                    "task_id": 1480434808,
                    "task_name": 3480434808,
                    "terminal_id": 89011480463480900778,
                    "program_ids": [
                        1480212808,
                        6280434808,
                        2481434808,
                        8783334808,
                        7480224808,
                        9080434808
                    ],
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

        @SerializedName(value = "terminals")
        private List<TerminalDetail> terminals;

        public String getDisplayDate() {
            return displayDate;
        }

        public void setDisplayDate(String displayDate) {
            this.displayDate = displayDate;
        }

        public List<TerminalDetail> getTerminals() {
            return terminals;
        }

        public void setTerminals(List<TerminalDetail> terminals) {
            this.terminals = terminals;
        }

        public class TerminalDetail {

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
            private List<Long> programIdList;

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

            public List<Long> getProgramIdList() {
                return programIdList;
            }

            public void setProgramIdList(List<Long> programIdList) {
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

}
