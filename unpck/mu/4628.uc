class 4628 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect24
		AttachOn=AM_LH
		AttachBoneName="Bone10"
		EffectClass=Class'LineageEffect.etc_strider_breath'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect26
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-0.900000)
		EffectClass=Class'LineageEffect.wh_recharge_ta'
	End Object
	Desc="신비한 오라" //Mysterious aura
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect24',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect26',SpecificStage=0)
}