package coffeemanager.infra.util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtil {

    @Value("${upload.path}")
    private String filePath;

    // 저장하기전
    public FileDto upload(MultipartFile file, String depth) throws IOException {
        //파일 비어있는지 확인
        if(file.isEmpty()){
            throw new IllegalArgumentException("File is empty");
        }

        //파일명, 저장 경로
        String originFileName = file.getOriginalFilename();
        String renameFileName = generateRenameFileName(originFileName);
        String savePath = createSavePath(depth);

        FileDto fileDto = new FileDto(originFileName, renameFileName, savePath);

        //실제 저장 아래 uploadFile 로
        uploadFile(file, fileDto);

        // 저장후 fileDto 반환
        return fileDto;
    }

    private void uploadFile(MultipartFile file, FileDto fileDto) throws IOException {
        File path = new File(filePath + fileDto.savePath());
        if (!path.exists()) {
            path.mkdirs();
        }

        File target = new File(filePath + fileDto.savePath() + fileDto.renameFileName());
        file.transferTo(target);
    }

    private String generateRenameFileName(String originFileName) {
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        return UUID.randomUUID().toString() + ext;
    }

    private String createSavePath(String depth) {
        LocalDate now = LocalDate.now();
        String pathDepth = (depth == null || depth.isEmpty()) ? "" : depth + "/";
        return pathDepth;
    }

}
