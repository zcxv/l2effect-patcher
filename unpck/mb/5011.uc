class 5011 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect19
		AttachOn=AM_LH
		AttachBoneName="Bone15"
		bAbsolute=True
		offset=(X=0.000000,Y=5.000000,Z=0.000000)
		EffectClass=Class'LineageEffect.rm_self_blaster_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect20
		AttachOn=AM_LA
		EffectClass=Class'LineageEffect.rm_self_blaster_ra'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect26
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_flame_strike_ta'
		bOnMultiTarget=True
	End Object
	Desc="유령자폭" //Suicide Ghost
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect19',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect20',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect26',SpecificStage=0)
}