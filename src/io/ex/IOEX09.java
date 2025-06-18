package io.ex;

/*
    사용자로부터 특정 디렉토리 경로를 입력받습니다.

    입력받은 경로가 존재하고 디렉토리라면, 해당 디렉토리 내에 있는 모든 파일과 서브 디렉토리의 목록을
    다음과 같은 형식으로 출력하세요. 이때, 각 항목이 파일인지 디렉토리인지 구분하여 표시하고, 파일인
    경우에는 파일 크기(KB 단위, 소수점 첫째 자리까지)도 함께 출력합니다.

    요구사항:
     + Scanner를 사용하여 사용자로부터 디렉토리 경로를 입력받습니다.
     + 입력받은 경로가 존재하지 않거나, 파일인 경우에는 적절한 메시지를 출력하고 프로그램을 종료합니다.

     + 출력 형식:
        * 디렉토리인 경우: [D] 디렉토리명
        * 파일인 경우: [F] 파일명 (크기 KB)

     + 파일 크기는 바이트 단위에서 KB 단위로 변환하여 소수점 첫째 자리까지 표시합니다. (1 KB = 1024 Bytes)
        * 예: 1500 Bytes -> 1.5 KB ( (double)1500 / 1024 하고, String.format("%.1f", ...) 사용)
        * 예: 500 Bytes -> 0.5 KB

    입력 예시:

    디렉토리 경로를 입력하세요: C:\MyFolder

    출력 예시 (만약 C:\MyFolder 안에 다음과 같은 내용이 있다면):
     * SubDir1 (디렉토리)
     * document.txt (파일, 크기 2048 Bytes)
     * image.jpg (파일, 크기 5632 Bytes)

    'C:\MyFolder' 디렉토리 내용:
    [D] SubDir1
    [F] document.txt (2.0 KB)
    [F] image.jpg (5.5 KB)

    만약 존재하지 않는 경로를 입력하면:
    'C:\NonExistentFolder'는 존재하지 않는 경로입니다.

    만약 파일 경로를 입력하면:
    'C:\MyFolder\myfile.txt'는 디렉토리가 아니라 파일입니다.

    힌트:
    * File 객체의 exists(), isDirectory(), listFiles() 메소드를 활용합니다.
    * listFiles()가 반환하는 File[] 배열을 순회하며 각 File 객체의 isFile(),
      getName(), length() 메소드를 사용합니다.
    * 파일 크기 변환 및 형식화에 주의하세요. String.format() 또는 DecimalFormat 클래스를 사용할 수 있습니다.
*/

import java.io.File;
import java.util.Scanner;

public class IOEX09 {

    public static void showDirectoryInfo(String path) {
        File fileOrDir = new File(path);

        // 경로 존재 여부 확인
        if (!fileOrDir.exists()) {
            throw new IllegalArgumentException("'" + path + "'는 존재하지 않는 경로입니다.");
        }

        // 디렉토리 여부 확인
        if (!fileOrDir.isDirectory()) {
            throw new IllegalArgumentException("'" + path + "'는 디렉토리가 아니라 파일입니다.");
        }

        // 디렉토리 내용 읽기
        File[] files = fileOrDir.listFiles();
        if (files == null) {
            throw new RuntimeException("'" + path + "' 디렉토리의 내용을 읽어올 수 없습니다.");
        }

        // 헤더 출력
        System.out.println("'" + path + "' 디렉토리 내용:");

        // 파일/디렉토리 목록 출력
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("[D] " + file.getName());
            } else {
                double sizeInKB = (double) file.length() / 1024;
                String sizeFormatted = String.format("%.1f", sizeInKB);
                System.out.println("[F] " + file.getName() + " (" + sizeFormatted + " KB)");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("디렉토리 경로를 입력하세요: ");
            String path = scanner.nextLine().trim();

            showDirectoryInfo(path);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}