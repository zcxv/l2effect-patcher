package m0nster.efpatcher.enums;

/**
 * @author PointerRage
 *
 */
public enum EAttachMethod {
	EAM_None, // don't attach
	EAM_RH, // attach to GetRHandBoneName();
	EAM_LH, 
	EAM_BoneSpecified, // attach to this.AttachBoneName
	EAM_AliasSpecified, // attach to TagAlias(AttachBoneName);
	EAM_Trail, // don't attach, trail the targetactor( assume physics of the emitter is PHYS_Trailer )
	EAM_RF, 
	EAM_LF;
}
