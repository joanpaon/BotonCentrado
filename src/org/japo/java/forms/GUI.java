/*
 * Copyright 2019 José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.forms;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.japo.java.events.AEM;
import org.japo.java.libraries.UtilesSwing;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public final class GUI extends JFrame {

    // Referencias
    private final Properties prp;

    // Componentes
    private JButton btnCierre;
    private JPanel pnlPpal;

    // Fuentes
    private Font fntBoton;

    // Constructor
    public GUI(Properties prp) {
        // Conectar Referencia
        this.prp = prp;

        // Inicialización Anterior
        initBefore();

        // Creación Interfaz
        initComponents();

        // Inicializacion Posterior
        initAfter();
    }

    // Construcción - GUI
    private void initComponents() {
        // Botón Cierre
        btnCierre = new JButton("Terminar");
        btnCierre.setFont(fntBoton.deriveFont(Font.BOLD, 40f));
        btnCierre.setFocusable(false);

        // Panel Principal
        pnlPpal.setLayout(new GridBagLayout());
        pnlPpal.add(btnCierre);

        // Ventana Principal
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Inicialización Anterior    
    private void initBefore() {
        // Establecer LnF
        UtilesSwing.establecerLnFProfile(prp.getProperty("look_and_feel_profile"));

        // Fuentes
        fntBoton = UtilesSwing.generarFuenteRecurso(prp.getProperty("font_resource"));

        // Panel Principal
        pnlPpal = new JPanel();

        // Ventana Principal
        setContentPane(pnlPpal);
    }

    // Inicialización Posterior
    private void initAfter() {
        // Establecer Favicon
        UtilesSwing.establecerFavicon(this, prp.getProperty("img_favicon_resource"));

        // Ventana Principal - Propiedades
        setTitle(prp.getProperty("form_title"));
        int width = Integer.parseInt(prp.getProperty("form_width"));
        int height = Integer.parseInt(prp.getProperty("form_height"));
        setSize(width, height);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        // Gestores de Eventos
        btnCierre.addActionListener(new AEM(this));
    }
}
