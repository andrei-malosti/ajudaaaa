package Property.Service.Property;

import Property.Imobiliaria;
import Enum.Type;
import Exception.ForeignException;

import java.util.Map;

public class Service {

    public Service() {
    }

    public void findById(int searchCode, Map<Integer,Imobiliaria> imobList){
        Imobiliaria imovel = new Imobiliaria();
        if (!imobList.isEmpty()) {
            if (imobList.containsKey(searchCode)){
                System.out.println("Código    Valor Aluguel    Tipo");
                System.out.println(imobList.get(searchCode));
                System.out.println();
            }
            else {
                System.out.println("code typed doesn't respond to none property\n");
            }
        }
    }


    public void findAll(Map<Integer,Imobiliaria> imobMap){
        Map<Integer,Imobiliaria> imobMapReturn;
        if (!imobMap.isEmpty()) {
            for (Integer key : imobMap.keySet()) {
                System.out.println(imobMap.get(key));
            }
            System.out.println();
        }
    }

    public void removeProperty(int removeCode, Map<Integer,Imobiliaria> propertyMap){
        if (!propertyMap.containsKey(removeCode)) {
            throw new ForeignException("code typed doesn't respond to none property");
        }
        propertyMap.remove(removeCode);
    }

    public void insertProperty(Integer code, Double rentValue, Type type, Map<Integer,Imobiliaria> propertyMap){
        if (propertyMap.containsKey(code)) {
            throw new ForeignException("already exists a property with this code");
        }
        propertyMap.put(code,new Imobiliaria(code,rentValue,type));
    }
}
