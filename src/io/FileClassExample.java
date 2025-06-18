package io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileClassExample {

    // Scanner를 클래스 레벨에서 관리
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 파일 또는 디렉토리 이름 변경
     * @param fileOrDir 변경할 파일/디렉토리
     * @return 변경된 File 객체 (변경 실패 시 원본 반환)
     */
    public static File rename(File fileOrDir) {
        if (!fileOrDir.exists()) {
            System.out.println("파일이 존재하지 않아 이름을 변경할 수 없습니다.");
            return fileOrDir;
        }

        System.out.println("\n새로운 이름을 입력하세요 (변경하지 않으려면 Enter): ");
        String newNameInput = scanner.nextLine().trim();

        if (!newNameInput.isEmpty()) {
            File newFile = new File(fileOrDir.getParent(), newNameInput);

            // 같은 이름인지 확인
            if (newFile.equals(fileOrDir)) {
                System.out.println("같은 이름입니다.");
                return fileOrDir;
            }

            // 이미 존재하는 파일/디렉토리인지 확인
            if (newFile.exists()) {
                System.out.println("이미 존재하는 이름입니다.");
                return fileOrDir;
            }

            if (fileOrDir.renameTo(newFile)) {
                System.out.println("'" + fileOrDir.getName() + "' -> '" +
                        newFile.getName() + "' 이름 변경 성공!");
                return newFile; // 변경된 File 객체 반환
            } else {
                System.out.println("이름 변경 실패.");
            }
        }
        return fileOrDir;
    }

    /**
     * 파일 또는 디렉토리 삭제 (디렉토리의 경우 재귀적으로 삭제)
     * @param fileOrDir 삭제할 파일/디렉토리
     */
    public static void sweep(File fileOrDir) {
        if (!fileOrDir.exists()) {
            System.out.println("삭제할 파일이 존재하지 않습니다.");
            return;
        }

        System.out.println("\n'" + fileOrDir.getName() + "'을(를) 삭제하시겠습니까? (y/n):");
        String deleteChoice = scanner.nextLine().trim();

        if (deleteChoice.equalsIgnoreCase("y")) {
            if (deleteRecursively(fileOrDir)) {
                System.out.println("'" + fileOrDir.getName() + "' 삭제 성공!");
            } else {
                System.out.println("'" + fileOrDir.getName() + "' 삭제 실패.");
            }
        }
    }

    /**
     * 재귀적으로 파일/디렉토리 삭제
     * @param file 삭제할 파일/디렉토리
     * @return 삭제 성공 여부
     */
    private static boolean deleteRecursively(File file) {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    if (!deleteRecursively(child)) {
                        return false;
                    }
                }
            }
        }
        return file.delete();
    }

    /**
     * 파일 정보 출력
     * @param fileOrDir 정보를 출력할 파일/디렉토리
     */
    public static void displayFileInfo(File fileOrDir) {
        System.out.println("\n'" + fileOrDir.getName() + "'은(는) 존재합니다.");

        if (fileOrDir.isFile()) {
            displayFileDetails(fileOrDir);
        } else if (fileOrDir.isDirectory()) {
            displayDirectoryDetails(fileOrDir);
        } else {
            System.out.println("타입: 파일도 디렉토리도 아닙니다 (예: 심볼릭 링크 등)");
        }
    }

    /**
     * 파일 상세 정보 출력
     */
    private static void displayFileDetails(File file) {
        System.out.println("타입: 파일");
        System.out.println("절대 경로: " + file.getAbsolutePath());
        System.out.println("파일 크기: " + formatFileSize(file.length()));

        long lastModifiedMillis = file.lastModified();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("마지막 수정일: " + sdf.format(new Date(lastModifiedMillis)));

        System.out.println("읽기 가능: " + file.canRead());
        System.out.println("쓰기 가능: " + file.canWrite());
        System.out.println("실행 가능: " + file.canExecute());
        System.out.println("숨김 파일: " + file.isHidden());
    }

    /**
     * 디렉토리 상세 정보 출력
     */
    private static void displayDirectoryDetails(File directory) {
        System.out.println("타입: 디렉토리");
        System.out.println("절대 경로: " + directory.getAbsolutePath());
        System.out.println("\n--- 디렉토리 내용 ---");

        File[] files = directory.listFiles();

        if (files != null && files.length > 0) {
            int fileCount = 0, dirCount = 0;

            for (File item : files) {
                String prefix = item.isDirectory() ? "[DIR]  " : "[FILE] ";
                String size = item.isFile() ? " (" + formatFileSize(item.length()) + ")" : "";
                System.out.println(prefix + item.getName() + size);

                if (item.isDirectory()) dirCount++;
                else fileCount++;
            }

            System.out.println("\n총 " + files.length + "개 항목 (디렉토리: " +
                    dirCount + ", 파일: " + fileCount + ")");
        } else {
            System.out.println("디렉토리가 비어있거나 접근할 수 없습니다.");
        }
    }

    /**
     * 파일 크기를 읽기 쉬운 형태로 변환
     */
    private static String formatFileSize(long bytes) {
        if (bytes < 1024) return bytes + " bytes";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.1f MB", bytes / (1024.0 * 1024));
        return String.format("%.1f GB", bytes / (1024.0 * 1024 * 1024));
    }

    /**
     * 새 디렉토리 생성
     */
    private static boolean createNewDirectory(File directory) {
        System.out.println("\n새 디렉토리를 생성하시겠습니까? (경로: " +
                directory.getAbsolutePath() + ") (y/n):");

        String choice = scanner.nextLine().trim();
        if (choice.equalsIgnoreCase("y")) {
            // mkdirs()는 중간 디렉토리도 함께 생성
            if (directory.mkdirs()) {
                System.out.println("디렉토리 '" + directory.getAbsolutePath() + "' 생성 성공");
                return true;
            } else {
                System.out.println("디렉토리 생성 실패.");
            }
        }
        return false;
    }

    /**
     * 임시 파일 생성 데모
     */
    private static void createTempFileDemo() {
        try {
            File tempFile = File.createTempFile("myTempApp", ".tmp");
            System.out.println("\n임시 파일 생성: " + tempFile.getAbsolutePath());
            System.out.println("프로그램 종료 시 자동 삭제됩니다.");
            tempFile.deleteOnExit();
        } catch (IOException e) {
            System.err.println("임시 파일 생성 중 오류: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("=== 파일/디렉토리 관리 프로그램 ===");
            System.out.println("정보를 확인할 파일 또는 디렉토리 경로를 입력하세요: ");

            String path = scanner.nextLine().trim();
            if (path.isEmpty()) {
                System.out.println("경로가 입력되지 않았습니다.");
                return;
            }

            File fileOrDir = new File(path);

            if (fileOrDir.exists()) {
                displayFileInfo(fileOrDir);

                // 이름 변경 (변경된 File 객체로 업데이트)
                fileOrDir = rename(fileOrDir);

                // 삭제 (삭제되면 이후 작업은 수행하지 않음)
                if (fileOrDir.exists()) {
                    sweep(fileOrDir);
                }
            } else {
                System.out.println("'" + path + "'은(는) 존재하지 않습니다.");

                // 새 디렉토리 생성 시도
                if (createNewDirectory(fileOrDir)) {
                    displayFileInfo(fileOrDir);
                }
            }

            // 임시 파일 생성 데모
            createTempFileDemo();

        } finally {
            // 리소스 정리
            scanner.close();
        }
    }
}