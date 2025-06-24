package com.example.trabajoClases.Controler;

import com.example.trabajoClases.Model.Entity.ItemFactura;
import com.example.trabajoClases.Model.Services.ItemFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items-factura")
@CrossOrigin(origins = "*")
public class ItemFacturaController {

    @Autowired
    private ItemFacturaService itemFacturaService;

    @GetMapping
    public ResponseEntity<List<ItemFactura>> getAllItems() {
        return ResponseEntity.ok(itemFacturaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemFactura> getItemById(@PathVariable Long id) {
        return itemFacturaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItemFactura> createItem(@RequestBody ItemFactura itemFactura) {
        return ResponseEntity.ok(itemFacturaService.save(itemFactura));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemFactura> updateItem(@PathVariable Long id, @RequestBody ItemFactura itemFactura) {
        return itemFacturaService.findById(id)
                .map(existingItem -> {
                    itemFactura.setIdItemFactura(id); // asegura que tenga el setter
                    return ResponseEntity.ok(itemFacturaService.save(itemFactura));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (itemFacturaService.findById(id).isPresent()) {
            itemFacturaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
