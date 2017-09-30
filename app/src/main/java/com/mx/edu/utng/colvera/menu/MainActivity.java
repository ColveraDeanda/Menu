package com.mx.edu.utng.colvera.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner cmbMenus;
    Spinner cmbMenuSeleccionado;
    Button btnAgregarPlatillo;
    Button btnMostrarOrden;
    Button btncreditos;
    String[] desayunos={"Huevos a la mexicana","Chilaquiles",
            "Juego de naranja","Coctel de frutas","Hotcakes","Crepas"};
    String[] comidas={"Chiles rellenos","Pollo empanizado",
                       "Enchiladas verdes","Enchiladas rojas","Mole de olla"};
    String[] cenas={"Tacos de pastor","Quesadillas","Ensalada",
                     "Pozole","Chocolate"};

    ArrayAdapter<String> adapter;
    MenuComponent desayunoMenu = new Menu("Menu desayunos","Desayunos");
    MenuComponent comidasMenu = new Menu("Menu comidas","Comidas");
    MenuComponent cenasMenu = new Menu("Menu cenas","Cenas");
    MenuComponent allMenus = new Menu("Todos los Menus", "Menu combinado");
    TextView txtOrden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cmbMenus = (Spinner)findViewById(R.id.cmb_menus);
        cmbMenuSeleccionado = (Spinner)findViewById(R.id.cmb_menu_disponible);

        adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item,desayunos);
        cmbMenuSeleccionado.setAdapter(adapter);

        cmbMenuSeleccionado.setOnItemSelectedListener(this);
        cmbMenus.setOnItemSelectedListener(this);

        btncreditos = (Button)findViewById(R.id.btn_creditos);
        txtOrden = (TextView)findViewById(R.id.txt_orden); // <-----
        btnMostrarOrden = (Button)findViewById(R.id.btn_mostrar_orden);
        btnAgregarPlatillo = (Button)findViewById(R.id.btn_agregar);
        btnAgregarPlatillo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                int m = (int) cmbMenus.getSelectedItemId();
                int p = (int) cmbMenuSeleccionado.getSelectedItemId();
                MenuItem menuItem = null;
                switch (m){
                    case 0: //desayunos
                        switch (p){
                            case 0:
                                menuItem = new MenuItem("Huevos a la mexicana",
                                        "Huevos estrellados con salsa verde",false,25.0);
                                break;
                            case 1:
                                menuItem = new MenuItem("Chilaquiles",
                                        "Chilaquiles en salsa roja",true,20.0);
                                break;
                            case 2:
                                menuItem = new MenuItem("Juego de naranja",
                                        "Naranja natural",true,10.0);
                                break;
                            case 3:
                                menuItem = new MenuItem("Coctel de frutas",
                                        "Frutas ricas",true,18.00);
                                break;
                            case 4:
                                menuItem = new MenuItem("Hotcakes",
                                        "Con miel de Maple",true,13.5);
                                break;
                            case 5:
                                menuItem = new MenuItem("Crepas",
                                        "Estilo frances",true,18.5);
                        }
                        desayunoMenu.add(menuItem);
                        Toast.makeText(getApplicationContext(),
                                "Se agregó platillo!!!",Toast.LENGTH_SHORT).show();
                        break;
                    case 1: //Comidas
                        switch (p){
                            case 0:
                                menuItem = new MenuItem("Chiles rellenos",
                                        "Chiles rellenos de queso panela",true,25.0);
                                break;
                            case 1:
                                menuItem = new MenuItem("Pollo empanizado",
                                        "Milanesa de pollo con papas",false,40.0);
                                break;
                            case 2:
                                menuItem = new MenuItem("Enchiladas verdes",
                                        "Con frijlitos",true,35.0);
                                break;
                            case 3:
                                menuItem = new MenuItem("Enchiladas rojas",
                                        "Con pollo y tambien con frijolitos",false,36.0);
                                break;
                            case 4:
                                menuItem = new MenuItem("Mole de olla",
                                        "El mejor de todos",true,32.0);
                        }
                        comidasMenu.add(menuItem);
                        Toast.makeText(getApplicationContext(),
                                "Se agregó platillo!!!",Toast.LENGTH_SHORT).show();
                        break;
                    case 2: // cenas
                        switch (p){
                            case 0: // tacos al pastor
                                menuItem = new MenuItem("Tacos al pastor",
                                        "Orden de 4 tacos",false,20.0);
                                break;
                            case 1: // quesadillas
                                menuItem = new MenuItem("Quesadillas",
                                        "Orden de 2 quesadillas de flor de calabaza",true,20.0);
                                break;
                            case 2:
                                menuItem = new MenuItem("Ensalada",
                                        "Con aderezo especial y mucha carne",false,22.0);
                                break;
                            case 3:
                                menuItem = new MenuItem("Pozole",
                                        "El más delicioso",true,25.0);
                                break;
                            case 4:
                                menuItem = new MenuItem("Chocolate",
                                        "Muy caliente",true,15.0);
                        }
                        cenasMenu.add(menuItem);
                        Toast.makeText(getApplicationContext(),
                                "Se agregó platillo!!!",Toast.LENGTH_SHORT).show();

                        break;

                }

            }

        });

        btnMostrarOrden.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                allMenus.add(desayunoMenu);
                allMenus.add(comidasMenu);
                allMenus.add(cenasMenu);
               // Toast.makeText(getApplicationContext(),
                 //       allMenus.print(),Toast.LENGTH_LONG).show();
                txtOrden.setText(allMenus.print());
            }

        });

        btncreditos.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),CreditosActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        int m = 0;//menu

        if(adapterView.getId()==R.id.cmb_menus){ //primer menu
            m = (int) cmbMenus.getSelectedItemId();
            switch((int)cmbMenus.getSelectedItemId()){
                case 0:
                    adapter = new ArrayAdapter<String>(this,
                            R.layout.spinner_item,desayunos);
                    cmbMenuSeleccionado.setAdapter(adapter);
                    break;
                case 1:
                    adapter = new ArrayAdapter<String>(this,
                            R.layout.spinner_item,comidas);
                    cmbMenuSeleccionado.setAdapter(adapter);
                    break;
                case 2:
                    adapter = new ArrayAdapter<String>(this,
                            R.layout.spinner_item,cenas);
                    cmbMenuSeleccionado.setAdapter(adapter);
                    break;
            }

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
