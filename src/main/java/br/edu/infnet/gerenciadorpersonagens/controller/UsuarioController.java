package br.edu.infnet.gerenciadorpersonagens.controller;

/*
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private static String msg;

    @GetMapping(value="/usuario/cadastro")
    public String exibirTelaCadastro() {
        return "usuario/cadastro";
    }

    @GetMapping(value="/usuario/lista")
    public String exibirTelaLista(Model model) {

        Collection<Usuario> lista = usuarioService.obterLista();

        model.addAttribute("listaUsuarios", lista);
        model.addAttribute("mensagemInclusao", msg);

        msg = null;

        return "usuario/lista";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Usuario usuario) {
        System.out.println("Inclusão realizada com sucesso: " + usuario);

        usuarioService.incluir(usuario);

        msg = "Usuário " + usuario.getNomeCompleto() + " incluído com sucesso!";
        return "redirect:/";
    }

    @GetMapping(value = "/usuario/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        Usuario usuario = usuarioService.obterPorId(id);
        usuarioService.excluir(id);
        msg = "Usuário " + usuario.getNomeCompleto() + " excluído com sucesso!";
        return "redirect:/usuario/lista";
    }
}

 */
