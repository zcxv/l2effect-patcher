class 4204 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect49
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.500000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.el_ice_dagger_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect50
		AttachOn=AM_LA
		offset=(X=2.000000,Y=0.000000,Z=0.000000)
		EffectClass=Class'LineageEffect.el_ice_dagger_pr'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect52
		AttachOn=AM_LA
		EffectClass=Class'LineageEffect.el_ice_dagger_fl'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect51
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_ice_dagger_ta'
	End Object
	Desc="출혈" //Bleeding
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect49',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect50',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect52',SpecificStage=0)
	ExplosionActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect51',SpecificStage=0)
}