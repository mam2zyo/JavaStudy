package string;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class StringExample5 {
    public static void main(String[] args) {
//        String.format() 을 사용한 형식화
        String formatted = String.format(
                "이름: %s, 나이: %d, 키: %.1f", "홍길동", 25, 175.5
        );
        System.out.println(formatted);

        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("금액: %,d원, 비율: %.2f%%", 1000000, 0.856);
        System.out.println(sb.toString());
        formatter.close();

        System.out.printf("16진수: %x, 8진수: %o, 과학적 표기법: %e\n",
                255, 64, 123.456);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateFormat.format(new Date());
        System.out.println("현재 날짜: " + dateStr);

        try {
            String inputDate = "2023-05-15 14:30:0";
            Date parseDate = dateFormat.parse(inputDate);
            System.out.println("파싱된 날짜: " + parseDate);
        } catch (ParseException e) {
            System.out.println("날짜 파싱 오류: " + e.getMessage());
        }
    }
}