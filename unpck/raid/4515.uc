class 4515 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect0
		AttachOn=AM_LA
		bSizeScale=True
		EffectClass=Class'LineageEffect.bl_curse_poison_ta'
	End Object
	Desc="Quest - BOSS Weakness(4544)" //Quest - BOSS Weakness (4544)
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect0',SpecificStage=0)
}