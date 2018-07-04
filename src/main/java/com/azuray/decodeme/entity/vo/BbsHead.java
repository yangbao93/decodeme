package com.azuray.decodeme.entity.vo;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BbsHead extends Model<BbsHead>{



    @Override
    protected Serializable pkVal() {
        return null;
    }
}
