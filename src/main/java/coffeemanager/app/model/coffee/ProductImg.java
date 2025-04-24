package coffeemanager.app.model.coffee;

import coffeemanager.infra.util.FileDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductImg {

    private Integer id;
    private String originFileName;
    private String renameFileName;
    private String savePath;

    public ProductImg(Integer id, FileDto fileDto) {
        this.id = id;
        this.originFileName = fileDto.originFileName();
        this.renameFileName = fileDto.renameFileName();
        this.savePath = fileDto.savePath();
    }

    public String getUrl() {
        return "/download/" + savePath + renameFileName;
    }
}
