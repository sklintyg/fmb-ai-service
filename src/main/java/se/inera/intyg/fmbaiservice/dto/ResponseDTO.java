package se.inera.intyg.fmbaiservice.dto;

import java.util.List;

public record ResponseDTO(String rubrik,
                          List<String> foljerRekomendationen,
                          List<String> foljerInteRekomendationen) {

}