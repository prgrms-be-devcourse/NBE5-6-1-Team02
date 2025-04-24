package coffeemanager.infra.util;

public record FileDto(
    String originFilename,
    String renameFilename,
    String savePath
) {

}
