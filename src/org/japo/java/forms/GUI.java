/*
 * Copyright 2017 José A. Pacheco Ondoño - joanpaon@gmail.com.
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

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.japo.java.events.AEM;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class GUI extends JFrame {
    // Tamaño de la ventana
    public static final int VENTANA_ANC = 300;
    public static final int VENTANA_ALT = 200;

    public GUI() {
        // Inicialización PREVIA
        beforeInit();

        // Creación del interfaz
        initComponents();

        // Inicialización POSTERIOR
        afterInit();
    }

    // Construcción del IGU
    private void initComponents() {
        // Fuente Personalizada
        String nombreFuente = "Consolas";
        int estiloFuente = Font.BOLD;
        int tallaFuente = 20;
        Font f = new Font(nombreFuente, estiloFuente, tallaFuente);

        // Gestor Eventos de Accion
        AEM aem = new AEM(this);
        
        // Otros componentes
        JButton btnBoton = new JButton();
        btnBoton.setText("Aceptar");
        btnBoton.setFont(f);
        btnBoton.addActionListener(aem);
        
        // Panel Principal
        JPanel pnlPpal = new JPanel();
//        pnlPpal.setLayout(new BorderLayout());
//        pnlPpal.add(btnBoton, BorderLayout.CENTER);
        pnlPpal.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlPpal.add(btnBoton);
        
        // Ventana principal
        setTitle("Botón Centrado");
        setContentPane(pnlPpal);
        setResizable(false);
        setSize(VENTANA_ANC, VENTANA_ALT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);        
    }

    // Inicialización antes del IGU
    private void beforeInit() {

    }

    // Inicialización después del IGU
    private void afterInit() {

    }

    // Cerrar programa
    public void terminarPrograma() {
        // Oculta la ventana
        setVisible(false);

        // Devuelve los recursos
        dispose();

        // Cierra el programa
        System.exit(0);
    }
}
