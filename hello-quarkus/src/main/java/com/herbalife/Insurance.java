package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

public interface Insurance {
}

@ApplicationScoped
@Named("primary")
class PrimaryInsurance implements Insurance {
}

@ApplicationScoped
@Named("thirdParty")
class ThirdPartyInsurance implements Insurance {
}
