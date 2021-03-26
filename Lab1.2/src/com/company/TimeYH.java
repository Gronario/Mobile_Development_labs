package com.company;

import java.util.Date;

public class TimeYH {
    Integer hours, minutes, seconds;

    TimeYH(){
        this(0,0,0);
    }

    TimeYH(Date date){
        this(date.getHours(), date.getMinutes(), date.getSeconds());
    }

    TimeYH(int hours, int minutes, int seconds) {
        boolean check = (hours >=0 && hours<24 && minutes>=0 && minutes<60 &&
                seconds>=0 && seconds<60);

        if (check) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }
        else {
            System.out.println("Invalid parameter for time");
            System.exit(0);
        }
    }

    String getStrTime(){
        String zone;
        if (this.hours >=0 && this.hours<12)
                zone = "AM";
        else
             zone = "PM";

        int temp_hours = (this.hours == 0 | this.hours == 12) ? 12 : this.hours%12;
        return String.format("%02d:%02d:%02d %s", temp_hours, this.minutes, this.seconds, zone);
    }

    TimeYH getSumTime(TimeYH timeOY){
//        TimeOY now = new TimeOY(new Date());
        int hours, minutes, seconds;
        hours = timeOY.hours + this.hours;
        minutes = timeOY.minutes + this.minutes;
        seconds = timeOY.seconds + this.seconds;

        if (seconds >59){
            seconds= seconds%60;
            minutes++;
        }

        if (minutes >59) {
            minutes = minutes % 60;
            hours++;
        }

        hours = hours%24;
        return new TimeYH(hours, minutes, seconds);
    }


    TimeYH getSubTime(TimeYH timeOY){

        int hours, minutes, seconds;
        hours = this.hours - timeOY.hours;
        minutes = this.minutes - timeOY.minutes;
        seconds = this.seconds - timeOY.seconds;

        if (seconds < 0){
            seconds = 60 + seconds;
            if ( minutes == 0 ){
                minutes=59;
                hours --;
            }
            else
                minutes--;
        }
        if (minutes <0){
            minutes = 60+minutes;
            if ( hours == 0 )
                hours=23;
            else
                hours--;
        }

        if (hours <0)
            hours = 24+hours;

        return new TimeYH(hours, minutes, seconds);

    }

    public static void main(String[] args) {
        TimeYH timeOY1 = new TimeYH();
        TimeYH timeOY2 = new TimeYH(11,55,15);
        TimeYH timeOY3 = new TimeYH(new Date());

        System.out.println("Current time");
        System.out.println(timeOY1.getStrTime());
        System.out.println("Sum: "+timeOY1.getStrTime() +" + "+"12:00:00");
        TimeYH sum1 = timeOY1.getSumTime(new TimeYH(12,0,0));
        System.out.println("\t\t"+sum1.getStrTime());
        System.out.println("Sub: "+timeOY1.getStrTime() +" - "+"00:01:01");
        TimeYH sub1 = timeOY1.getSubTime(new TimeYH(0,1,1));
        System.out.println("\t\t"+sub1.getStrTime());
        System.out.println();

        System.out.println("Current time");
        System.out.println(timeOY2.getStrTime());
        System.out.println("Sum: "+timeOY2.getStrTime() +" + "+"15:06:00");
        TimeYH sum2 = timeOY2.getSumTime(new TimeYH(15,6,0));
        System.out.println("\t\t"+sum2.getStrTime());
        System.out.println("Sub: "+timeOY2.getStrTime() +" - "+"12:02:01");
        TimeYH sub2 = timeOY2.getSubTime(new TimeYH(12,2,1));
        System.out.println("\t\t"+sub2.getStrTime());
        System.out.println();

        System.out.println("Current time");
        String time33 = timeOY3.getStrTime();
        System.out.println(time33);
        System.out.println("Sum: "+time33 +" + "+"20:30:00");
        TimeYH sum3 = timeOY3.getSumTime(new TimeYH(20,30,0));
        System.out.println("\t\t"+sum3.getStrTime());
        System.out.println("Sub: "+time33 +" - "+"14:02:59");
        TimeYH sub3 = timeOY3.getSubTime(new TimeYH(14,2,59));
        System.out.println("\t\t"+sub3.getStrTime());
        System.out.println();

        TimeYH time1 = new TimeYH(23, 59, 59);
        TimeYH time2 = new TimeYH(12, 0, 1);
        System.out.println("23:59:59 + 12:00:01 = " + time1.getSumTime(time2).getStrTime());

        TimeYH time3 = new TimeYH(0, 0, 0);
        TimeYH time4 = new TimeYH(0, 0, 1);
        System.out.println("00:00:00 - 00:00:01 = " + time3.getSubTime(time4).getStrTime());


        TimeYH time11 = new TimeYH(0, 0, 0);
        TimeYH time22 = new TimeYH(12, 0, 0);
        System.out.println("00:00:00 = " + time11.getStrTime());
        System.out.println("12:00:00 = " + time22.getStrTime());

    }




}
