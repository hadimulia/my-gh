package com.app.gh.endpoint;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.generic.endpoint.contract.BaseResponse;
import com.app.generic.persistence.validator.field.ValidationCheck;
import com.app.gh.persistence.dto.CoaDto;
import com.app.gh.service.service.CoaService;

@Controller
@RequestMapping("/coa")
public class CoaController {

	@Autowired
	private CoaService service;
	
	@Value("${spring.application.name}")
    String appName;
	
	@GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

	@PostMapping("/save")
	public ResponseEntity<BaseResponse> save(@RequestBody CoaDto request) {
		if (request != null) {
			ValidationCheck.hasValidate(request);
		}

		CoaDto dto = service.save(request);

		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setResponse(dto);
		return ResponseEntity.ok().body(baseResponse);

	}

	@PostMapping("/delete/{id}")
	public ResponseEntity<BaseResponse> delete(@PathVariable("id") Long id) {

		service.remove(id);

		BaseResponse baseResponse = new BaseResponse();
		return ResponseEntity.ok().body(baseResponse);

	}

	@PostMapping("/get/{id}")
	public ResponseEntity<BaseResponse> get(@PathVariable("id") Long id) {

		CoaDto dto = service.getById(id);

		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setResponse(dto);
		return ResponseEntity.ok().body(baseResponse);

	}

	@PostMapping("/store/{storeId}")
	public ResponseEntity<BaseResponse> getByStoreId(@PathVariable("storeId") Long storeId) {

		Set<CoaDto> list = service.getByStoreId(storeId);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setResponse(list);
		return ResponseEntity.ok().body(baseResponse);

	}
}
