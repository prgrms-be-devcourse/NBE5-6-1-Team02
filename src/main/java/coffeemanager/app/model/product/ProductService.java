package coffeemanager.app.model.product;

import coffeemanager.app.model.product.dto.Product;

import coffeemanager.util.file.FileUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final FileUtil fileUtil;

    @Transactional
    public void registProduct(String pd_IMG, Product dto) {
        productRepository.insert(dto);

    }


}
