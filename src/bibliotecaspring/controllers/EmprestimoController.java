package bibliotecaspring.controllers;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import bibliotecaspring.daos.EmprestimoDAO;
import bibliotecaspring.models.Emprestimo;

@Controller
public class EmprestimoController {
	@RequestMapping("/emprestimo/form")
	public String form() {
		return "emprestimo/form";
	}


	@PostMapping("/emprestimo")
	public String adicionar(Emprestimo emprestimo) {
		
		EmprestimoDAO eDAO = new EmprestimoDAO();
		Long idAluno = emprestimo.getAluno().getId();
		Long idLivro = emprestimo.getLivro().getId();
 		if (eDAO.verificarAluno(idAluno) && eDAO.verificarLivro(idLivro)) {
 			eDAO.inserir(emprestimo);
 			return "redirect:/emprestimo";
 		} else { return "/erro"; }
	}
	
	@PostMapping("/emprestimo/devolucao")
	public String devolucao(Emprestimo emprestimo){
		Long idAluno = emprestimo.getAluno().getId();
		Long idLivro = emprestimo.getLivro().getId();
		EmprestimoDAO eDAO = new EmprestimoDAO();
		eDAO.devolucao(idAluno, idLivro);
		
		return "redirect:/emprestimo";

	}

	@GetMapping("/emprestimo")
	public ModelAndView listarEmprestimos(){
		EmprestimoDAO eDAO = new EmprestimoDAO();
		List<Emprestimo> lista = eDAO.getEmprestimos();
		ModelAndView model = new ModelAndView("emprestimo/lista");
		model.addObject("emprestimos", lista);
		return model;
	}
	
	@GetMapping("/emprestimo/atrasados")
	public ModelAndView listarEmprestimosAtrasados(){
		EmprestimoDAO eDAO = new EmprestimoDAO();
		List<Emprestimo> lista = eDAO.getEmprestimosAtrasados();
		ModelAndView model = new ModelAndView("emprestimo/listaAtrasados");
		model.addObject("emprestimos", lista);
		return model;
	}
	
	@GetMapping("/emprestimo/ativos")
	public ModelAndView listarEmprestimosAtivos(){
		EmprestimoDAO eDAO = new EmprestimoDAO();
		List<Emprestimo> lista = eDAO.getEmprestimosAtivos();
		ModelAndView model = new ModelAndView("emprestimo/listaAtivos");
		model.addObject("emprestimos", lista);
		return model;
	}
	
	

}
