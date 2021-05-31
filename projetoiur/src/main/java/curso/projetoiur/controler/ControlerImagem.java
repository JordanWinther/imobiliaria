package curso.projetoiur.controler;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControlerImagem {
	
	//Salva o seu arquivo de carregamento em uma pasta
	private static String PastaUpload = "C:\\sts-4.5.0.RELEASE\\workSpaceSpring\\projetoiur\\src\\main\\resources\\static\\img\\";
	
	@PostMapping("/upload")
	public String SingleFileUpload (@RequestParam("file") MultipartFile file,
															RedirectAttributes redirectAttributes) {
		
		if(file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message","Por favor, selecione um arquivo");
			return "redirect:/uploadStatus";
		}
		
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(PastaUpload + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "Seu arquivo foi carregado com sucesso '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }
	
	
	
	
	
	
	
	//Pasta(variável) static para salvar arquivos
	private String pastaUpload = "C:\\sts-4.5.0.RELEASE\\workSpaceSpring\\projetoiur\\src\\main\\resources\\static\\img\\";
	
	//Método para salvar arquivos em pasta
	@PostMapping("/upload3")
	public String salvarArquivoUpload(@RequestParam("file") MultipartFile file,
																	RedirectAttributes redirectAttributes) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Arquivo em branco");
		}
		
		try {
			
			byte[] bytes = file.getBytes();
			Path path = Paths.get(pastaUpload + file.getOriginalFilename() + file.getSize());
			Files.write(path, bytes);
			redirectAttributes.addFlashAttribute
			("message", "Seu arquivo '" + file.getOriginalFilename() +  "' de tamanho " + file.getSize() + " foi salvo com sucesso!");
			return "redirect:/uploadStatus";
		} catch ( IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/uploadStatus";
	}
	
	@PostMapping("/upload2")
	public String upload3(@RequestParam ("file") MultipartFile file, RedirectAttributes attributes) {
		if (file.isEmpty()) {
			attributes.addFlashAttribute("message3", "Nenhum arquivo foi selecionado");
			return "redirect:/uploadStatus";
		}
		try {
			byte [] bytes = file.getBytes();
			Path path = Paths.get(pastaUpload + file.getOriginalFilename() + file.getSize());
			Files.write(path, bytes);
			attributes.addFlashAttribute("message3", "Seu arquivo ' " + file.getOriginalFilename()+
																	" 'de tamanho ' " + file.getSize() / 1000 +"KB, foi salvo com sucesso.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/uploadStatus";
	}
	

	
	
	
	@GetMapping("/uploadStatus")
	public String statusUpload() {
		return "cadastro/uploadstatus";
		
		
	}
	
		
}


