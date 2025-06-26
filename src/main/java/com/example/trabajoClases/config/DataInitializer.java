package com.example.trabajoClases.config;

import com.example.trabajoClases.Model.Dao.*;
import com.example.trabajoClases.Model.Entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.*;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(
            ClasificacionRepository clasificacionRepo,
            CompetenciaRepository competenciaRepo,
            PersonaRepository personaRepo,
            ProveedorRepository proveedorRepo,
            RolRepository rolRepo,
            TipoPagoRepository tipoPagoRepo,
            UsuarioRepository usuarioRepo,
            ProductoRepository productoRepo,
            FacturaRepository facturaRepo,
            ItemFacturaRepository itemFacturaRepo
    ) {
        return args -> {
            if (productoRepo.count() > 0 || personaRepo.count() > 0 || facturaRepo.count() > 0) {
                System.out.println("❌ Ya existen datos. Se omite carga inicial.");
                return;
            }

            // CLASIFICACIONES
            List<Clasificacion> clasificaciones = Arrays.asList(
                    new Clasificacion(null, "Electrodomésticos", null),
                    new Clasificacion(null, "Tecnología", null),
                    new Clasificacion(null, "Muebles", null),
                    new Clasificacion(null, "Ropa", null),
                    new Clasificacion(null, "Alimentos", null),
                    new Clasificacion(null, "Limpieza", null),
                    new Clasificacion(null, "Libros", null),
                    new Clasificacion(null, "Deportes", null),
                    new Clasificacion(null, "Hogar", null),
                    new Clasificacion(null, "Juguetes", null)
            );
            clasificacionRepo.saveAll(clasificaciones);

            // COMPETENCIAS
            List<Competencia> competencias = Arrays.asList(
                    new Competencia(null, "LECTURA", "Puede leer registros del sistema."),
                    new Competencia(null, "ESCRITURA", "Puede crear o modificar registros."),
                    new Competencia(null, "BORRADO", "Puede eliminar registros."),
                    new Competencia(null, "FACTURACION", "Puede realizar facturas."),
                    new Competencia(null, "REPORTE", "Puede generar reportes."),
                    new Competencia(null, "ADMIN", "Acceso total."),
                    new Competencia(null, "USUARIO", "Acceso limitado."),
                    new Competencia(null, "GESTION_PRODUCTO", "Puede manejar productos."),
                    new Competencia(null, "GESTION_USUARIO", "Puede manejar usuarios."),
                    new Competencia(null, "GESTION_ROL", "Puede manejar roles.")
            );
            competenciaRepo.saveAll(competencias);

            // TIPO PAGO
            List<TipoPago> tiposPago = Arrays.asList(
                    new TipoPago(null, "Efectivo", "Pago con billetes o monedas", null),
                    new TipoPago(null, "Tarjeta Crédito", "Visa, MasterCard, etc.", null),
                    new TipoPago(null, "Transferencia", "Depósito bancario", null),
                    new TipoPago(null, "PayPal", "Pago en línea", null)
            );
            tipoPagoRepo.saveAll(tiposPago);

            // PERSONAS
            List<Persona> personas = Arrays.asList(
                    new Persona(null, "Juan", "Pérez", "1101122334", "0991122334", "juan@gmail.com", null),
                    new Persona(null, "Lucía", "Martínez", "1102233445", "0992233445", "lucia@gmail.com", null),
                    new Persona(null, "Carlos", "Gómez", "1103344556", "0993344556", "carlos@gmail.com", null),
                    new Persona(null, "María", "Fernández", "1104455667", "0994455667", "maria@gmail.com", null),
                    new Persona(null, "Pedro", "Ramírez", "1105566778", "0995566778", "pedro@gmail.com", null),
                    new Persona(null, "Ana", "Torres", "1106677889", "0996677889", "ana@gmail.com", null),
                    new Persona(null, "Luis", "Díaz", "1107788990", "0997788990", "luis@gmail.com", null),
                    new Persona(null, "Sofía", "López", "1108899001", "0998899001", "sofia@gmail.com", null),
                    new Persona(null, "Diego", "Castro", "1109900112", "0999900112", "diego@gmail.com", null),
                    new Persona(null, "Paula", "Vega", "1110011223", "0990011223", "paula@gmail.com", null)
            );
            personaRepo.saveAll(personas);

            // PROVEEDORES
            List<Proveedor> proveedores = Arrays.asList(
                    new Proveedor(null, "1790012312001", "022345678", "ElectroAndes S.A.", "Ecuador", "contacto@electroandes.com", "USD", null),
                    new Proveedor(null, "0991122334001", "022334455", "Muebles Quito", "Ecuador", "ventas@mueblesquito.com", "USD", null),
                    new Proveedor(null, "1792233445001", "022556677", "TechWorld", "Colombia", "info@techworld.com", "COP", null),
                    new Proveedor(null, "1103344556001", "022667788", "Juguetes Mundo", "Perú", "ventas@juguetesmundo.com", "PEN", null),
                    new Proveedor(null, "1794455667001", "022778899", "Alimentos El Sol", "Ecuador", "contacto@elsol.com", "USD", null),
                    new Proveedor(null, "1105566778001", "022889900", "Limpieza Total", "Ecuador", "servicio@limpiezatotal.com", "USD", null),
                    new Proveedor(null, "1796677889001", "022990011", "Textiles Loja", "Ecuador", "textiles@loja.com", "USD", null),
                    new Proveedor(null, "1797788990001", "022001122", "Editorial Andes", "Ecuador", "editorial@andes.com", "USD", null),
                    new Proveedor(null, "1798899001001", "022112233", "Deportes Rápidos", "Chile", "ventas@deportesrapidos.cl", "CLP", null),
                    new Proveedor(null, "1799900112001", "022223344", "Casa y Hogar", "Ecuador", "info@casayhogar.com", "USD", null)
            );
            proveedorRepo.saveAll(proveedores);

            // ROLES
            Rol admin = new Rol(null, "ADMIN", true, competencias);
            Rol user = new Rol(null, "USER", true, List.of(competencias.get(0), competencias.get(1)));
            rolRepo.saveAll(List.of(admin, user));

            // USUARIOS
            Usuario usuarioAdmin = new Usuario(null, "admin", "admin123", personas.get(0), List.of(admin));
            Usuario usuarioNormal = new Usuario(null, "lucia", "lucia123", personas.get(1), List.of(user));
            usuarioRepo.saveAll(List.of(usuarioAdmin, usuarioNormal));

            // PRODUCTOS con nombres reales asignados al campo unidades
            List<String> nombres = List.of(
                    "Refrigeradora LG", "Laptop Lenovo", "Sofá de cuero", "Camisa blanca de algodón",
                    "Arroz Súper Extra", "Detergente Líquido", "Libro: Aprende Java", "Balón Adidas",
                    "Ventilador Silencioso", "Muñeca Barbie "
            );
            List<Producto> productos = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Producto p = new Producto();
                p.setStock("100");
                p.setPrecioUnitario(10.0 + i);
                p.setUnidades(nombres.get(i)); // Aquí van los nombres de los productos
                p.setClasificacion(clasificaciones.get(i));
                p.setProveedor(proveedores.get(i));
                p.setIva(i % 2 == 0);
                productos.add(p);
            }
            productoRepo.saveAll(productos);

            // FACTURA
            Factura factura = new Factura();
            factura.setRuc("1234567890001");
            factura.setFecha(LocalDate.now());
            factura.setTipoPago(tiposPago.get(0));
            factura.setPersona(personas.get(0));
            factura.setDescuento(5.0);
            factura.setTotal(50.0);
            facturaRepo.save(factura);

            // ITEMS FACTURA
            List<ItemFactura> items = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                Producto prod = productos.get(i);
                ItemFactura item = new ItemFactura();
                item.setFactura(factura);
                item.setProducto(prod);
                item.setCantidad(2);
                item.setPrecio(prod.getPrecioUnitario());
                item.setSubtotal(prod.getPrecioUnitario() * 2);
                items.add(item);
            }
            itemFacturaRepo.saveAll(items);
        };
    }
}
