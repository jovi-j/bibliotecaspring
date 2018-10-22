package bibliotecaspring.controllers;

import java.util.Calendar;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bibliotecaspring.daos.AlunoDAO;
import bibliotecaspring.daos.LivroDAO;
import bibliotecaspring.daos.EmprestimoDAO;
import bibliotecaspring.models.Livro;
import bibliotecaspring.models.Aluno;
import bibliotecaspring.models.Emprestimo;

@Controller
public class EmprestimoController {
	@RequestMapping("/emprestimo/form")
	public String form() {
		return "emprestimo/form";
	}


	@PostMapping("/emprestimo")
	public String adicionar(int matriculaAluno , long idLivro) {
		
		AlunoDAO aDAO = new AlunoDAO();
		Aluno aluno = new Aluno();
		aluno = aDAO.getByMatricula(matriculaAluno);
		long idAluno = aluno.getId();
				
		LivroDAO lDAO = new LivroDAO();
		Livro livro = new Livro();
		livro = lDAO.getById(idLivro);
		
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setAluno(aluno);
		emprestimo.setLivro(livro);
		emprestimo.setDataEmprestimo(Calendar.getInstance());
		
		
		EmprestimoDAO eDAO = new EmprestimoDAO();
 		if (eDAO.verificarAluno(idAluno) && eDAO.verificarLivro(idLivro)) {
 			eDAO.inserir(emprestimo);
 			return "redirect:/emprestimo";
 		} else { return "/erro"; }
	}
	
	@PostMapping("/emprestimo/devolucao")
	public String devolucao(long idAluno, long idLivro){
		
		Aluno aluno = new Aluno();
		Livro livro = new Livro();
		Emprestimo emprestimo = new Emprestimo();
		
		
		AlunoDAO aDAO = new AlunoDAO();
		LivroDAO lDAO = new LivroDAO();
		EmprestimoDAO eDAO = new EmprestimoDAO();
		
		aluno = aDAO.getById(idAluno);
		livro = lDAO.getById(idLivro);
		
		emprestimo.setAluno(aluno);		
		emprestimo.setLivro(livro);
		
		eDAO.devolucao(emprestimo);
		
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
		ModelAndView model = new ModelAndView("emprestimo/lista");
		model.addObject("emprestimos", lista);
		return model;
	}
	
	@GetMapping("/emprestimo/ativos")
	public ModelAndView listarEmprestimosAtivos(){
		EmprestimoDAO eDAO = new EmprestimoDAO();
		List<Emprestimo> lista = eDAO.getEmprestimosAtivos();
		ModelAndView model = new ModelAndView("emprestimo/lista");
		model.addObject("emprestimos", lista);
		return model;
	}
	
	

}
