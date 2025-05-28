package string.ex;

/*
    로그 파일 분석기 만들기
    주어진 로그 문자열에서 다음 작업을 수행하는 프로그램을 작성하세요:

    각 로그 라인에서 타임스탬프, 로그 레벨, 메시지를 추출
    ERROR 레벨의 로그만 필터링
    추출된 ERROR 로그들을 시간순으로 정렬 (문자열 비교로)
    결과를 보기 좋은 형태로 출력

    조건:
    StringJoiner 또는 StringBuilder를 사용하여 효율적으로 문자열을 처리하세요
    정규표현식 대신 String의 기본 메소드들(indexOf, substring 등)을 사용하세요

    입력 예:
    String logData = "2023-05-15 14:30:25 INFO 사용자 로그인 성공\n" +
            "2023-05-15 14:32:10 ERROR 데이터베이스 연결 실패\n" +
            "2023-05-15 14:25:45 WARN 메모리 사용량 80% 초과\n" +
            "2023-05-15 14:35:20 ERROR 파일 읽기 권한 없음\n" +
            "2023-05-15 14:28:15 INFO 백업 작업 완료\n" +
            "2023-05-15 14:40:30 ERROR 네트워크 타임아웃";
    예상 출력:
    === ERROR 로그 분석 결과 ===
    [14:32:10] 데이터베이스 연결 실패
    [14:35:20] 파일 읽기 권한 없음
    [14:40:30] 네트워크 타임아웃
    총 ERROR 개수: 3개
*/

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

public class StringEx9 {

    static final String[] LOG_LEVELS = {"ERROR", "INFO", "WARN"};

    @Getter
    @AllArgsConstructor
    static class LogEntry {
        String timestamp;
        String level;
        String message;
    }

    public static String getLogLevel(String logLine) {
        for (String level : LOG_LEVELS) {
            if (logLine.contains(" " + level + " ")) return level;
        }
        return null;
    }

    public static String getTimeStamp(String logLine) {
        String level = getLogLevel(logLine);
        if (level == null) return "";
        String timeStamp = logLine.substring(0, logLine.indexOf(level)).trim();
        return timeStamp;
    }

    public static String getMessage(String logLine) {
        String level = getLogLevel(logLine);
        if (level == null) return "";
        String message = logLine.substring(logLine.indexOf(level) + level.length() + 1).trim();
        return message;
    }

    public static void filterLog(List<LogEntry> logList, String logLevel) {

        List<LogEntry> filteredList = new ArrayList<>();

        for (LogEntry log : logList) {
            if (log.getLevel().equals(logLevel)) {
                filteredList.add(log);
            }
        }

        filteredList.sort((a, b) -> a.timestamp.compareTo(b.timestamp));

        System.out.println("=== " + logLevel + " 로그 분석 결과 ===");
        for (LogEntry log : filteredList) {
            String time = "[" + log.timestamp.split(" ")[1] + "]";
            StringJoiner sj = new StringJoiner(" ");
            sj.add(time);
            sj.add(log.message);
            System.out.println(sj.toString());
        }
        System.out.println("총 " + logLevel + " 개수: " + filteredList.size() + "개");
    }


    public static void main(String[] args) {
        String logData = "2023-05-15 14:30:25 INFO 사용자 로그인 성공\n" +
                "2023-05-15 14:32:10 ERROR 데이터베이스 연결 실패\n" +
                "2023-05-15 14:25:45 WARN 메모리 사용량 80% 초과\n" +
                "2023-05-15 14:35:20 ERROR 파일 읽기 권한 없음\n" +
                "2023-05-15 14:28:15 INFO 백업 작업 완료\n" +
                "2023-05-15 14:40:30 ERROR 네트워크 타임아웃";

        String[] logLines = logData.split("\n");

        List<LogEntry> logList = new ArrayList<>();

        for (String line : logLines) {
            String stamp = getTimeStamp(line);
            String level = getLogLevel(line);
            String message = getMessage(line);

            logList.add(new LogEntry(stamp, level, message));
        }

        filterLog(logList, "ERROR");
    }
}