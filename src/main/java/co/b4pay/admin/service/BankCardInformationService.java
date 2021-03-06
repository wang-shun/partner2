package co.b4pay.admin.service;

import co.b4pay.admin.common.biz.service.CrudService;
import co.b4pay.admin.common.util.DateUtil;
import co.b4pay.admin.controller.Utils.Utils;
import co.b4pay.admin.dao.BankCardInformationDao;
import co.b4pay.admin.entity.BankCardInformation;
import co.b4pay.admin.entity.base.Params;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankCardInformationService extends CrudService<BankCardInformationDao, BankCardInformation> {

    /**
     * 更改状态
     *
     */
    public int updateStatus(String id, int status) {
        Params params = Params.create("id", id);
        params.put("status", status);
        try {
            params.put("nowDate", DateUtil.YMdhms.parse(DateUtil.YMdhms.format(Utils.now())));
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }
        return dao.updateStatus(params);
    }


    public List<BankCardInformation> findListByID(String merchantId) {
        return dao.findListById(merchantId);
    }


    public List<BankCardInformation> findListByIdAndStatus(String merchantId,int status) {
        return dao.findListByIdAndStatus(merchantId,status);
    }
}
