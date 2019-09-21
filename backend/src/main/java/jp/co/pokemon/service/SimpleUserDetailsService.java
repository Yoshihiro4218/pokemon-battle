package jp.co.pokemon.service;

import jp.co.pokemon.config.SimpleLoginUser;
import jp.co.pokemon.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("simpleUserDetailsService")
@AllArgsConstructor
public class SimpleUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String email) {
        // emailでデータベースからユーザーエンティティを検索する
        return userRepository.findByEmail(email)
                             .map(SimpleLoginUser::new)
                             .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
