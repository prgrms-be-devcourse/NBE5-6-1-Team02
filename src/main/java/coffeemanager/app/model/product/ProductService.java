package coffeemanager.app.model.product;

import coffeemanager.app.model.product.dto.Product;
import coffeemanager.infra.response.ResponseCode;
import coffeemanager.util.file.FileDto;
import coffeemanager.util.file.FileUtil;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import coffeemanager.infra.error.exceptions.CommonException;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final FileUtil fileUtil;

    @Transactional
    public void registProduct(MultipartFile pd_IMG, Product dto) {
        try {

            FileDto savedFile = fileUtil.upload(pd_IMG, "upload");

            dto.setImg(savedFile.savePath());

            productRepository.insert(dto);

        } catch (IOException e) {
            throw new CommonException(ResponseCode.INTERNAL_SERVER_ERROR, e);
        }
    }

}
