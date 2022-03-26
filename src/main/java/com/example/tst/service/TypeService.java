package com.example.tst.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.tst.entity.TypeEntity;
import com.example.tst.exception.NotFoundTypeException;
import com.example.tst.model.Type;
import com.example.tst.respository.TypeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {
    @Autowired
    private TypeRespository typeRespository;

    public TypeService() {
    }

    public TypeEntity post(TypeEntity type) {
        return (TypeEntity)this.typeRespository.save(type);
    }

    public List<Type> getAllType() {
        List<Type> types = new ArrayList();
        Iterator var2 = this.typeRespository.findAll().iterator();

        while(var2.hasNext()) {
            TypeEntity entity = (TypeEntity)var2.next();
            types.add(Type.toModel(entity));
        }

        return types;
    }

    public Type getOneType(Long id) throws NotFoundTypeException {
        TypeEntity type = (TypeEntity)this.typeRespository.findById(id).get();
        if (type == null) {
            throw new NotFoundTypeException("Not found the type");
        } else {
            return Type.toModel(type);
        }
    }

    public Long delete(Long id) {
        this.typeRespository.deleteById(id);
        return id;
    }
}

