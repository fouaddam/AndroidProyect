package org.fouad.appandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.fouad.appandroid.Clases.Producto;
import org.fouad.appandroid.ConnectDatabase.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class listView extends AppCompatActivity {

    ListView listview;
    List<Producto>listProductos=new ArrayList<>();
    List<String> listanombre;

    public List<Producto> ProductosList(){
        Producto producto1=new Producto(1,"disco duro","123hgz");
        Producto producto2=new Producto(2,"Ram","123gh");
        Producto producto3=new Producto(3,"Rom","1235j");
        listProductos.add(producto1);
        listProductos.add(producto2);
        listProductos.add(producto3);
        listProductos.add(producto1);
        listProductos.add(producto2);
        listProductos.add(producto3);

        return listProductos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Model model=new Model();
        model.insertProducto(ProductosList().get(0),this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listview = findViewById(R.id.listViewProduct);
        listanombre = new ArrayList<>();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            listanombre = ProductosList().stream()
                    .map(Producto::getNombre).collect(Collectors.toList());
        }

        ListAdapter listAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                        listanombre);
        listview.setAdapter(listAdapter);
    }

}