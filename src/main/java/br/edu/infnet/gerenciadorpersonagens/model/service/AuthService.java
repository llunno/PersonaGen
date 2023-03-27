package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Administrador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.SessionStatus;

@Service
public class AuthService {

    public String loggedUserSessionAttr = "usuario";
    public String adminUser = "Administrador";
    public String criadorUser = "Criador";

    public boolean isLoggedIn(HttpSession session) {
        Object loggedUserObject = session.getAttribute(loggedUserSessionAttr);
        return loggedUserObject != null;
    }

    public String getLoggedUserType(HttpSession session) {
        Object loggedUserObject = session.getAttribute(loggedUserSessionAttr);

        if (loggedUserObject instanceof Administrador) {
            return adminUser;
        }
        else if (loggedUserObject instanceof Criador) {
            return criadorUser;
        }
        else {
            return null;
        }
    }

    public Object getSessionObject(HttpSession session) {
        return session.getAttribute(loggedUserSessionAttr);
    }

    public void logout(HttpSession session, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        session.removeAttribute(loggedUserSessionAttr);
    }
}
