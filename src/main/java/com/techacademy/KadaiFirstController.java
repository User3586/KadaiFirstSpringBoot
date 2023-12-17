package com.techacademy;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{yyyymmdd}")
    public String dispDayOfWeek(@PathVariable String yyyymmdd) {
        LocalDateTime.now().getDayOfWeek();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate ld = LocalDate.parse(yyyymmdd, f);

        DayOfWeek dow = ld.getDayOfWeek();
        String now = null;
        if (DayOfWeek.FRIDAY.getValue() == dow.getValue()) {
            now = "金曜日";
        } else if (DayOfWeek.THURSDAY.getValue() == dow.getValue()) {
            now = "木曜日";
        } else if (DayOfWeek.WEDNESDAY.getValue() == dow.getValue()) {
            now = "水曜日";
        }else if (DayOfWeek.TUESDAY.getValue() == dow.getValue()) {
            now = "火曜日";
        } else if (DayOfWeek.MONDAY.getValue() == dow.getValue()) {
            now = "月曜日";
        } else if (DayOfWeek.SUNDAY.getValue() == dow.getValue()) {
            now = "日曜日";
        } else if (DayOfWeek.SATURDAY.getValue() == dow.getValue()) {
            now = "土曜日";
        }
        return now;
    }

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "計算結果：" + res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "計算結果：" + res;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "計算結果：" + res;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "計算結果：" + res;
    }
}
