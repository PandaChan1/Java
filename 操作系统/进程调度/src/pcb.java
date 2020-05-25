import java.util.Comparator;


    class pcb{
        String tag;//标记
        int intime;//进入时间
        int serv;//服务时间
        int prio;//优先级
        double wrun; //带权周转
        int end; //完成时间
        int run; //周转时间
        int sheng; //剩余时间
        boolean ok=false;  //是否执行完成
        public pcb(){};
        public pcb(String tag,int intime,int serv,int prio,int end,double wrun,int run){
            this.tag=tag;
            this.intime=intime;
            this.serv =serv;
            this.prio=prio;
            this.end=end;
            this.wrun=wrun;
            this.run=run;
        }

        public boolean isOk() {
            return ok;
        }
        public void setOk(boolean ok) {
            this.ok = ok;
        }

        public int getSheng() {
            return sheng;
        }

        public void setSheng(int sheng) {
            this.sheng = sheng;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public void setIntime(int intime) {
            this.intime = intime;
        }

        public void setServ(int serv) {
            this.serv = serv;
        }

        public void setPrio(int prio) {
            this.prio = prio;
        }
        public void setWrun(double wrun){
            this.wrun=wrun;
        }
        public void setEnd(int end){
            this.end=end;
        }
        public void setRun(int run){
            this.run=run;
        }
        public String getTag() {
            return tag;
        }

        public int getIntime() {
            return intime;
        }

        public int getServ() {
            return serv;
        }

        public int getPrio() {
            return prio;
        }
        public int getEnd(){
            return end;
        }

        public int getRun() {
            return run;
        }
        public double getWrun() {
            return wrun;
        }

        public static class sortbyIntime implements Comparator<pcb> {  //进入时间排序

            @Override
            public int compare(pcb o1, pcb o2) {
                return o1.getIntime()-o2.getIntime();
            }
        }
        public static class sortbyPrio implements Comparator<pcb>{ //优先级排序

            @Override
            public int compare(pcb o1, pcb o2) {
                if (o1.getIntime()-o2.getIntime()!=0) return o1.getIntime()-o2.getIntime(); //进入时间不同，按进入时间升序
                else return o2.getPrio()-o1.getPrio(); //进入时间相同时按优先级降序排列
            }
        }
        public static class shortbyServ implements Comparator<pcb>{ //短作业排序

            @Override
            public int compare(pcb o1, pcb o2) {
                if (o1.getIntime()-o2.getIntime()!=0) return o1.getIntime()-o2.getIntime(); //按进入时间升序
                else return o1.getServ()-o2.getServ(); //按短作业升序
            }
        }
        public static class shortbyRr implements Comparator<pcb>{ //时间片轮转

            @Override
            public int compare(pcb o1, pcb o2) {
                return o1.getEnd()-o2.getEnd(); //按完成时间升序
            }
        }
    }


