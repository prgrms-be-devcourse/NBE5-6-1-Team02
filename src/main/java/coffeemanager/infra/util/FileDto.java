package coffeemanager.infra.util;

public record FileDto(
    String originFileName,
    String renameFileName,
    String savePath
) {

}
