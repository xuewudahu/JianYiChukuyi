package com.rq.net.bean;

import java.util.List;

public class CourSmallPoleOutLibBean
{
    private int code;
    private String msg;
    private UnpackDataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UnpackDataBean getData() {
        return data;
    }

    public void setData(UnpackDataBean data) {
        this.data = data;
    }

    public static class UnpackDataBean
    {
        private DataBean other_package;

        public DataBean getOther_package() {
            return other_package;
        }

        public void setOther_package(DataBean other_package) {
            this.other_package = other_package;
        }

        public static class DataBean{
            private int total_nums;

            private List<String> lists;

            public int getTotal_nums() {
                return total_nums;
            }

            public void setTotal_nums(int total_nums) {
                this.total_nums = total_nums;
            }

            public List<String> getLists() {
                return lists;
            }

            public void setLists(List<String> lists) {
                this.lists = lists;
            }
        }
    }
}
