package com.example.trabajoClases.Model.Services;

import com.example.trabajoClases.Model.Dao.ItemFacturaRepository;
import com.example.trabajoClases.Model.Entity.ItemFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemFacturaService {

    private final ItemFacturaRepository itemFacturaRepository;

    @Autowired
    public ItemFacturaService(ItemFacturaRepository itemFacturaRepository) {
        this.itemFacturaRepository = itemFacturaRepository;
    }

    public List<ItemFactura> findAll() {
        return itemFacturaRepository.findAll();
    }

    public Optional<ItemFactura> findById(Long id) {
        return itemFacturaRepository.findById(id);
    }

    public ItemFactura save(ItemFactura itemFactura) {
        return itemFacturaRepository.save(itemFactura);
    }

    public void deleteById(Long id) {
        itemFacturaRepository.deleteById(id);
    }
}
