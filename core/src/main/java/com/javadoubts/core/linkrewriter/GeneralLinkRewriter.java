package com.javadoubts.core.linkrewriter;

import com.adobe.cq.xf.ExperienceFragmentLinkRewriterProvider;
import com.adobe.cq.xf.ExperienceFragmentVariation;
import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        service = ExperienceFragmentLinkRewriterProvider.class,
        immediate = true
)
@ServiceDescription("XF to Target link rewriter")
@Designate(ocd = GeneralLinkRewriter.XFLinkRewriterConfig.class)
public class GeneralLinkRewriter implements ExperienceFragmentLinkRewriterProvider {

    @ObjectClassDefinition(name = "XF Link Rewriter Config")
    public @interface XFLinkRewriterConfig {
    }

    private static final Logger log = LoggerFactory.getLogger(GeneralLinkRewriter.class);

    @Override
    public String rewriteLink(String link, String tag, String attribute) {
        // Add a log statement to indicate the link being rewritten
        log.info("Rewriting link - Original: {}, Tag: {}, Attribute: {}", link, tag, attribute);

        // Your link rewriting logic goes here

        // Returning the modified link (replace with your actual logic)
        return link;
    }

    @Override
    public boolean shouldRewrite(ExperienceFragmentVariation experienceFragment) {
        boolean shouldRewrite = StringUtils.startsWith(experienceFragment.getPath(),
                "/content/experience-fragments/wknd/language-masters/en");

        // Add a log statement to indicate whether link rewriting should be applied
        log.info("Should rewrite for path {}: {}", experienceFragment.getPath(), shouldRewrite);

        return shouldRewrite;
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
