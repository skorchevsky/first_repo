package core.helpers;

import com.beust.jcommander.Parameterized;

public @interface RunWith {
    Class<Parameterized> value();
}
